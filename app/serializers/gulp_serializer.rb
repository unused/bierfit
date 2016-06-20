class GulpSerializer < ActiveModel::Serializer
  attributes :ml, :from, :to

  def ml
    object.amount_in_ml
  end

  def from
    object.consumed_at.strftime API_DATETIME_FORMAT
  end

  def to
    to_date = object.consumed_at + object.duration_in_seconds.seconds
    to_date.strftime API_DATETIME_FORMAT
  end
end
