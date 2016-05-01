class User < ActiveRecord::Base
  # TODO add :confirmable and maybe :omniauthable via twitter ;)
  devise :database_authenticatable, :registerable, :recoverable,
    :rememberable, :trackable, :validatable

  validates :username, presence: true, uniqueness: true
  validates :email, presence: true

  has_many :beers, dependent: :destroy
  has_many :gulps, through: :beers
  has_many :consume_events

  # hmm...
  def drinking?
    ConsumeEvent.where(user: self).current.count > 0
  end
end
