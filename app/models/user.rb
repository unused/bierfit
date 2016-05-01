class User < ActiveRecord::Base
  # TODO add :confirmable and maybe :omniauthable via twitter ;)
  devise :database_authenticatable, :registerable, :recoverable,
    :rememberable, :trackable, :validatable

  validates :username, presence: true, uniqueness: true
  validates :email, presence: true
end
