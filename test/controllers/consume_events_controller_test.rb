require 'test_helper'

class ConsumeEventsControllerTest < ActionController::TestCase
  setup do
    @consume_event = consume_events(:one)
  end

  test "should get index" do
    get :index
    assert_response :success
    assert_not_nil assigns(:consume_events)
  end

  test "should create consume_event" do
    assert_difference('ConsumeEvent.count') do
      post :create, consume_event: {
        analog_reading:           @consume_event.analog_reading,
        conductance_in_micromhos: @consume_event.conductance_in_micromhos,
        consumed_at:              @consume_event.consumed_at,
        force_in_newtons:         @consume_event.force_in_newtons,
        fsr_resistance_in_ohms:   @consume_event.fsr_resistance_in_ohms,
        voltage_reading_in_mv:    @consume_event.voltage_reading_in_mv
      }, format: :json
    end

    assert_response :success
  end

end
