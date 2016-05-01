
FactoryGirl.define do
  factory :beer do
    # we only accept size 0.5 atm but prepare for other sizes as well
    size     { "0.5" }
    gulps

  end
end
