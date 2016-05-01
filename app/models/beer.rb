class Beer < ActiveRecord::Base
  has_many :gulps, dependent: :destroy
  belongs_to :user

  validates :finished_at, presence: true
  validates :size, inclusion: { in: %w(0.33 0.5 1.0) }
end
