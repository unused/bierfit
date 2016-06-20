class Beerstogram
  def initialize(beers)
    @beers = beers
  end

  def as_json(*_)
    []
  end
end

