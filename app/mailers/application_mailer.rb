# Mailer Base
class ApplicationMailer < ActionMailer::Base
  default from: 'from@bierfit.com'
  layout 'mailer'
end
