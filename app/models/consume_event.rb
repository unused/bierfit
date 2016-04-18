class ConsumeEvent < ActiveRecord::Base
  # belongs_to :user

  scope :consumed_on,
    ->(date) { where(consumed_at: (date.beginning_of_day..date.end_of_day)) }
end
