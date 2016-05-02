class Device < ActiveRecord::Base
  belongs_to :owner, class_name: :user, foreign_key: :owner_id
  has_many :users, through: :device_registrations

  validates :owner, presence: true
  validates :label, presence: true
  validates :api_key, presence: true, uniqueness: true
end
