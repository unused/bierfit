namespace :bierfit do
  desc "analyze consume events and extract gulps"
  task analyze_data: :environment do
    ConsumeEvents.where(processed: false)
  end
end
