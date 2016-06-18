
FactoryGirl.define do
  factory :consume_event do

    analog_reading           { Faker::Number.between(0, 1000) }
    voltage_reading_in_mv    { analog_reading / 10 }
    fsr_resistance_in_ohms   { analog_reading }
    conductance_in_micromhos { 1000 - analog_reading }
    force_in_newtons         { analog_reading / 100 }
    consumed_at              { Faker::Time.backward(14) }
    processed                { false }

    user
  end
end
