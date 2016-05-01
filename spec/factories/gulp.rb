
FactoryGirl.define do
  factory :gulp do
    beer
    amount_in_ml { Faker::Number.between(50, 120) }
    consumed_at  { Faker::Time.between 14 }
  end
end
