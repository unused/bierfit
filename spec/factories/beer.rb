
FactoryGirl.define do
  factory :beer do
    # we only accept size 0.5 atm but prepare for other sizes as well
    size        { "0.5" }
    finished_at { Faker::Time.backward 7 }
    user

    factory :beer_with_gulps do
      after(:create) do |beer, _|
        gulp_count = Faker::Number.between(2, 7)
        gulp_ml    = 500 / gulp_count
        gulps_at   = [beer.finished_at]
        gulps_at   = gulp_count.times.map {
          gulps_at.last - Faker::Number.between(2, 7).minutes
        }

        gulps_at.reverse.each do |gulp_at|
          create :gulp, {
             beer: beer, consumed_at: gulp_at,
             amount_in_ml: gulp_ml - Faker::Number.between(0, 20)
          }
        end
      end
    end
  end
end
