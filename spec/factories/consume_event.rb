
FactoryGirl.define do
  factory :consume_event do
    # creating simple chaotic data atm but may use sequences to create stuff
    # that actually makes sense...

    analog_reading           { Faker::Number.between(0, 1000) }
    voltage_reading_in_mv    { Faker::Number.between(0, 1000) }
    fsr_resistance_in_ohms   { Faker::Number.between(0, 1000) }
    conductance_in_micromhos { Faker::Number.between(0, 1000) }
    force_in_newtons         { Faker::Number.between(0, 1000) }
    consumed_at              { Faker::Time.backward(14) }

    user
  end
end
