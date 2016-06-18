# Beer drinker
class User < ActiveRecord::Base
  # TODO: add :confirmable and maybe :omniauthable via twitter ;)
  devise :database_authenticatable, :registerable, :recoverable,
         :rememberable, :trackable, :validatable

  # TODO: -> uniqueness incasesensitive!
  validates :username, presence: true, uniqueness: true
  validates :slug,     presence: true, uniqueness: true
  validates :email,    presence: true

  has_many :beers, dependent: :destroy
  has_many :gulps, through: :beers

  has_many :devices, dependent: :destroy
  has_many :device_registrations, dependent: :delete_all

  has_many :consume_events

  before_validation :create_slug # we could do this on update as well

  # hmm...
  def drinking?
    ConsumeEvent.where(user: self).current.count > 0
  end

  def to_param
    slug
  end

  private

  def create_slug
    self.slug = username.parameterize.downcase if username
  end
end