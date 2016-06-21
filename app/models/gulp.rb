class Gulp < ActiveRecord::Base
  belongs_to :beer

  validates :beer, presence: true
  validates :amount_in_ml, presence: true
  validates :consumed_at, presence: true
  validates :duration_in_seconds, presence: true
end
