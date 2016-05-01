
FactoryGirl.define do
  factory :beer do
    # we only accept size 0.5 atm but prepare for other sizes as well
    size        { "0.5" }
    finished_at { Faker::Time.backward 7 }
    user

    factory :beer_with_gulps do
      transient do
        gulps_count Faker::Number.between(3, 8)
      end

      after(:create) do |beer, evaluator|
        create_list(:gulp, evaluator.gulps_count, beer: beer)
      end
    end
  end
end
