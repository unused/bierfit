class Beeralyzer
  NULL_STATE_TOLERANCE = 15

  def initialize(events)
    @collected_data = events
  end

  class BottleState
    def add_event(value:, date:)
      @values ||= []
      @values << value
      @start_time ||= @end_time = date
    end

    def value
      @values.reduce(:+) / @values.size if @values
    end
  end

  def bottle_states
    bottle_states = @collected_data.each_with_object([]) do |event, states|
      if event[:value].between?(0, NULL_STATE_TOLERANCE)
        states << BottleState.new
      else
        states << BottleState.new if states.empty?
        states.last.add_event(event)
        states
      end
    end
    bottle_states.reject { |state| state.value.nil? }
  end

  def gulps
    gulps = []
    bottle_states.each_cons(2) do |states|
      prev, curr = states
      gulps << Gulp.new(amount_in_ml: prev.value - curr.value)
    end
    gulps
  end

  def extract
    gulps.inject([]) do |beers, gulp|
      if beers.empty? || gulp.amount_in_ml < 0
        beers << Beer.new
      else
        beers = [Beer.new] if beers.empty?
        beers.last.gulps << gulp
      end
      beers
    end
  end
end
