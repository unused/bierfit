class BeerSerializer < ActiveModel::Serializer
  attributes :finished_at
  has_many :gulps

  def finished_at
    object.finished_at.strftime API_DATETIME_FORMAT
  end
end
