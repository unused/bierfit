class Device < ActiveRecord::Base
  has_one :owner, class_name: :user
  # has_many :users

  validates :label, presence: true
  validates :api_key, presence: true
end
