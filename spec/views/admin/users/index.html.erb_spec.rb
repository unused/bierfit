require 'rails_helper'

RSpec.describe "admin/users/index", type: :view do
  before(:each) do
    assign(:admin_users, [
      Admin::User.create!(),
      Admin::User.create!()
    ])
  end

  it "renders a list of admin/users" do
    render
  end
end
