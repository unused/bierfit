class ConsumeEventsController < ApplicationController
  before_action :set_consume_event, only: [:show, :edit, :update, :destroy]

  # GET /consume_events
  # GET /consume_events.json
  def index
    @date = Date.today
    @date = Date.parse(params[:date]) if params[:date]
    @consume_events = ConsumeEvent.consumed_on @date
  end

  # POST /consume_events.json
  def create
    render status: 404 unless request.format.json?
    @consume_event = ConsumeEvent.new consume_event_params.merge(
      consumed_at: Time.at(Integer(consume_event_params[:consumed_at])).to_datetime
    )

    respond_to do |format|
      if @consume_event.save
        format.json { render json: { message: 'yo' }, status: :created }
      else
        format.json { render json: @consume_event.errors, status: :unprocessable_entity }
      end
    end
  end

  def nuke
    ConsumeEvent.delete_all
    redirect_to consume_events_path, notice: "foo... all gone..."
  end

  private
    # Never trust parameters from the scary internet, only allow the white list through.
    def consume_event_params
      params.require(:consume_event).permit(:user, :analog_reading,
                                            :voltage_reading_in_mv,
                                            :fsr_resistance_in_ohms,
                                            :conductance_in_micromhos,
                                            :force_in_newtons, :consumed_at)
    end
end
