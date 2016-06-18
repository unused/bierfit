class UsersController < ApplicationController
  before_action :set_user, only: [:edit, :update]
  skip_before_action :authenticate_user!, only: [:show]

  def show
    if params[:slug] == current_user.try(:username)
      set_user
    else
      @user = User.where(public: true).find_by_slug params[:slug]
    end

    @stats = UserStatistics.new(@user)

    redirect_to root_path unless @user
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
    params.require(:user).permit(:name, :public)
  end
end
