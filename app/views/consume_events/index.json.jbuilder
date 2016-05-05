json.array!(@consume_events) do |consume_event|
  json.extract! consume_event, :id, :analog_reading, :voltage_reading_in_mv,
                :fsr_resistance_in_ohms, :conductance_in_micromhos,
                :force_in_newtons, :consumed_at
end
