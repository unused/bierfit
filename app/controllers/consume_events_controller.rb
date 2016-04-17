class ConsumeEventsController < ApplicationController
  before_action :set_consume_event, only: [:show, :edit, :update, :destroy]

  # GET /consume_events
  # GET /consume_events.json
  def index
    @consume_events = ConsumeEvent.all
  end

  # GET /consume_events/1
  # GET /consume_events/1.json
  def show
  end

  # GET /consume_events/new
  def new
    @consume_event = ConsumeEvent.new
  end

  # GET /consume_events/1/edit
  def edit
  end

  # POST /consume_events
  # POST /consume_events.json
  def create
    @consume_event = ConsumeEvent.new(consume_event_params)

    respond_to do |format|
      if @consume_event.save
        format.html { redirect_to @consume_event, notice: 'Consume event was successfully created.' }
        format.json { render :show, status: :created, location: @consume_event }
      else
        format.html { render :new }
        format.json { render json: @consume_event.errors, status: :unprocessable_entity }
      end
    end
  end

  # PATCH/PUT /consume_events/1
  # PATCH/PUT /consume_events/1.json
  def update
    respond_to do |format|
      if @consume_event.update(consume_event_params)
        format.html { redirect_to @consume_event, notice: 'Consume event was successfully updated.' }
        format.json { render :show, status: :ok, location: @consume_event }
      else
        format.html { render :edit }
        format.json { render json: @consume_event.errors, status: :unprocessable_entity }
      end
    end
  end

  # DELETE /consume_events/1
  # DELETE /consume_events/1.json
  def destroy
    @consume_event.destroy
    respond_to do |format|
      format.html { redirect_to consume_events_url, notice: 'Consume event was successfully destroyed.' }
      format.json { head :no_content }
    end
  end

  private
    # Use callbacks to share common setup or constraints between actions.
    def set_consume_event
      @consume_event = ConsumeEvent.find(params[:id])
    end

    # Never trust parameters from the scary internet, only allow the white list through.
    def consume_event_params
      params.require(:consume_event).permit(:analog_reading, :voltage_reading_in_mv, :fsr_resistance_in_ohms, :conductance_in_micromhos, :force_in_newtons, :user_id, :consumed_at)
    end
end
