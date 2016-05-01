
FactoryGirl.define do
  factory :user, aliases: [:owner] do
    name     { Faker::Name.name }
    username { Faker::Internet.username }
    email    { Faker::Internet.email }
    admin    { false }

    factory :admin do
      admin { true }
    end
  end
end
