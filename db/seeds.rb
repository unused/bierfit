
$stdout.sync = true # print nicely

print "creating default user..."
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

print "generate users..."
(100..250).to_a.sample.times do |i|
  User.create(
    username: Faker::Internet.user_name,
    email: Faker::Internet.email,
    password: Faker::Internet.password
  )
  print "." if i % 5 == 0
end

puts ""
