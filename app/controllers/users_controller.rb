class UsersController < ApplicationController
  before_action :set_user, only: [:edit, :update]

  skip_before_action :authenticate_user!, only: [:show]

  def show
    @user = User.find_by_slug params[:id]
  end

  def edit

  end

  def update
    if @user.update(user_params)
      redirect_to @user, notice: 'User was successfully updated.'
    else
      render :edit
    end
  end

  private
    def set_user
      @user = current_user
    end

    def user_params
      params.require(:user).permit(:name)
    end
end
