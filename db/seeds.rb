
$stdout.sync = true # print nicely


if ENV['BUILD_TEST_DATA']
  require 'factory_girl'
  FactoryGirl.find_definitions

  print "creating default users..."
  user = User.create(
    username: 'demo',
    email: 'demo@example.com',
    password: 'demo@example.com'
  )
  print "."
  admin = User.create(
    username: 'admin',
    email: 'admin@example.com',
    password: 'admin@example.com',
    admin: true,
  )
  print "."

  puts ""

  print "generate some users..."
  (100..250).to_a.sample.times do |i|
    begin
      FactoryGirl.create(:user)
      print "."
    rescue
      # ignore username conflicts creation errors
    end
  end

  puts ""

  user_ids   = User.all.pluck :id
  start_date = Date.today - 1.month

  print "generate some drinking sessions..."
  (start_date..Date.today).each do |day|
    user_ids.sample(15).each do |user_id|
      time = day.to_time + Faker::Number.between(13, 17).hours
      Faker::Number.between(2, 10).times do
        time += Faker::Number.between(60, 90).minutes
        FactoryGirl.create(:beer_with_gulps, user_id: user_id, finished_at: time)
        print "."
      end
    end
  end

  puts ""
end
