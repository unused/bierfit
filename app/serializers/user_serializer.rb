class UserSerializer < ActiveModel::Serializer
  attributes :username, :bierfit_since, :average_beer_per_session,
             :average_gulp_length

  def bierfit_since
    object.created_at.strftime API_DATETIME_FORMAT
  end

  def average_beer_per_session
    format("%.2f", stats.average_beer_per_session_day)
  end

  def average_gulp_length
    format("%.2f", stats.average_gulp_amount)
  end

  private

  def stats
    @stats ||= UserStatistics.new object
  end
end
