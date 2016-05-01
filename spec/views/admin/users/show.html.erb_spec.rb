require 'rails_helper'

RSpec.describe "admin/users/show", type: :view do
  before(:each) do
    @admin_user = assign(:admin_user, Admin::User.create!())
  end

  it "renders attributes in <p>" do
    render
  end
end
