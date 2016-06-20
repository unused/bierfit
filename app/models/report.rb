class Report
  def initialize(beers)
    @beers = beers
  end

  def total_beer
    @beers.count
  end

  def days
    @days = @beers.map { |beer| beer.finished_at.beginning_of_day }.uniq
  end

  def gulps
    @gulps = @beers.map(&:gulps).flatten
  end

  def sessions_count
    days.count
  end

  def average_gulp_per_beer
    beer_gulps = @beers.map { |beer| beer.gulps.size }
    return 0 if beer_gulps.empty?
    beer_gulps.sum.to_f / beer_gulps.size
  end

  def average_gulp_length
    return 0 if gulps.empty?
    gulps.map(&:amount_in_ml).sum.to_f / gulps.size
  end

  def max_gulp
    return 0 if gulps.empty?
    gulps.map(&:amount_in_ml).max
  end

  def summary
    {
      total_beer: total_beer,
      sessions: sessions_count,
      average_gulp_per_beer: "%.2f" % average_gulp_per_beer,
      average_gulp_length: "%.2f" % average_gulp_length,
      max_gulp: max_gulp
    }
  end
end
