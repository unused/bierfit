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

  test "should get new" do
    get :new
    assert_response :success
  end

  test "should create consume_event" do
    assert_difference('ConsumeEvent.count') do
      post :create, consume_event: { analog_reading: @consume_event.analog_reading, conductance_in_micromhos: @consume_event.conductance_in_micromhos, consumed_at: @consume_event.consumed_at, force_in_newtons: @consume_event.force_in_newtons, fsr_resistance_in_ohms: @consume_event.fsr_resistance_in_ohms, user_id: @consume_event.user_id, voltage_reading_in_mv: @consume_event.voltage_reading_in_mv }
    end

    assert_redirected_to consume_event_path(assigns(:consume_event))
  end

  test "should show consume_event" do
    get :show, id: @consume_event
    assert_response :success
  end

  test "should get edit" do
    get :edit, id: @consume_event
    assert_response :success
  end

  test "should update consume_event" do
    patch :update, id: @consume_event, consume_event: { analog_reading: @consume_event.analog_reading, conductance_in_micromhos: @consume_event.conductance_in_micromhos, consumed_at: @consume_event.consumed_at, force_in_newtons: @consume_event.force_in_newtons, fsr_resistance_in_ohms: @consume_event.fsr_resistance_in_ohms, user_id: @consume_event.user_id, voltage_reading_in_mv: @consume_event.voltage_reading_in_mv }
    assert_redirected_to consume_event_path(assigns(:consume_event))
  end

  test "should destroy consume_event" do
    assert_difference('ConsumeEvent.count', -1) do
      delete :destroy, id: @consume_event
    end

    assert_redirected_to consume_events_path
  end
end
