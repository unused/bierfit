class Admin::ApplicationController < ApplicationController
  before_action :authenticate_admin!

  private

    def authenticate_admin!
      current_user.admin?
    end
end
