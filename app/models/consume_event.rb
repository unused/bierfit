# Drinking event, actual stuff that comes from the meideckel device
class ConsumeEvent < ActiveRecord::Base
  belongs_to :user

  validates :consumed_at, presence: true, future: true

  scope :current, -> { where('consumed_at >= ?', 5.minutes.ago) }
  scope :consumed_on, (lambda do |date|
    where consumed_at: (date.beginning_of_day..date.end_of_day)
  end)

  # NOTE monkeypatch input for now...
  def consumed_at=(consumed_at)
    unless consumed_at.is_a? DateTime
      consumed_at = Time.at(Integer(consumed_at)).to_datetime
    end
    write_attribute(:consumed_at, consumed_at)
  end
end
