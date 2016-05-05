# Drinking event, actual stuff that comes from the meideckel device
class ConsumeEvent < ActiveRecord::Base
  # belongs_to :user

  scope :consumed_on, lambda do |date|
    where consumed_at: (date.beginning_of_day..date.end_of_day)
  end

  def consumed_at=(consumed_at)
    consumed_at = Integer(consumed_at).to_datetime if consumed_at.is_a? DateTime

    @consumed_at = consumed_at
  end
end
