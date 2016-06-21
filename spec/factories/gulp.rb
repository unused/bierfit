
FactoryGirl.define do
  factory :gulp do
    beer
    amount_in_ml { Faker::Number.between(50, 120) }
    consumed_at  { Faker::Time.between 14 }
    duration_in_seconds { Faker::Number.between(5, 60) }
  end
end
