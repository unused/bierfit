namespace :bierfit do
  desc "analyze consume events and extract gulps"
  task analyze_data: :environment do
    drinkers = ConsumeEvents.select(:user_id, :created_at)
                            .where(processed: false)
                            .group_by(:user_id)

    drinkers.each do |drinker|
      # wait until session is over...
      next unless drinker[:created_at] < 5.minutes.ago

      ce = ConsumeEvents.where(processed: false, user_id: drinker[:user_id])
                        .order(consumed_at: :asc)
                        .pluck(:analog_reading, :consumed_at)
      ce.map! { |e| { value: e.analog_reading, date: e.consumed_at } }

      Beeralyzer.new(ce).extract.each(:save)
    end
  end
end
