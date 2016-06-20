class UsersController < ApplicationController
  before_action :set_user, only: [:edit, :update]
  skip_before_action :authenticate_user!, only: [:show]

  def show
    fetch_user
    @stats = UserStatistics.new(@user)

    redirect_to root_path unless @user
    respond_to do |format|
      format.html {} # index.html.erb
      format.json { render json: @user }
    end
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

  def fetch_user
    if params[:slug] == current_user.try(:username)
      set_user
    else
      @user = User.where(public: true).find_by_slug params[:slug]
    end
  end

  def set_user
    @user = current_user
  end

  def user_params
    params.require(:user).permit(:name, :public)
  end
end
