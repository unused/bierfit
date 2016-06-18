
class UserStatistics
  DRINKER_LEVEL = [
    'a member of Bierdonnerstag',
    'a citizen of Bierbardos',
    'a Bierat',
    'a visitor of Bierbardos',
    'a tourist on the Bierberg',
    'an intern'
  ].freeze

  def initialize(user)
    @user = user
  end

  def first_beer
    beers.order(:finished_at).first
  end

  def last_beer
    beers.order(:finished_at).last
  end

  def beers_count
    beers.count
  end

  def max_beer_per_day
    beers.group('date(finished_at)').count.values.max
  end

  def average_gulp_amount
    gulps.average(:amount_in_ml)
  end

  def average_gulp_duration
    gulps.average(:duration_in_seconds)
  end

  def total_beers_count
    Beer.count
  end

  def total_max_beer_per_day
    Beer.group(:user_id).group('date(finished_at)').count.values.max
  end

  def drinker_in_words
    DRINKER_LEVEL[total_max_beer_per_day - max_beer_per_day] || 'a beginner'
  end

  def bierfit_position_in_percentage
    user_positions = Beer.select('count(*) as cnt, user_id')
                         .group(:user_id).order('cnt ASC')
    user_position  = user_positions.map(&:user_id).index(@user.id)
    user_position.to_f / user_positions.to_a.size * 100
  end

  def beers
    @user.beers
  end

  # TODO: use collected queries to reduce db-requests on demand:
  private

  def gulps
    Gulp.joins(:beer).where('beers.user_id = ?', @user.id)
  end

  def beer_stats
    @beer_stats || collect_beer_stats
  end

  def collect_beer_stats
    @beer_stats = Beer.select('...')
  end

  def gulp_stats
    @gulp_stats || collect_gulp_stats
  end

  def collect_gulp_stats
    @gulp_stats = Beer.select('...')
  end
end
