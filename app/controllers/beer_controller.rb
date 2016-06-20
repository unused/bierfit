class BeerController < ApplicationController
  before_action :set_user

  def index
    render json: @user.beers.order(finished_at: :desc).limit(params[:limit])
  end

  def daily
    beers  = fetch_beers date.beginning_of_day..date.end_of_day
    report = Report.new(beers)
    render json: report.summary.merge(beerstogram: Beerstogram.new(beers))
  end

  def weekly
    beers  = fetch_beers (date - 1.week).beginning_of_day..date.end_of_day
    report = Report.new(beers)
    render json: report.summary.merge(beerstogram: Beerstogram.new(beers))
  end

  def monthly
    beers  = fetch_beers (date - 1.month).beginning_of_day..date.end_of_day
    report = Report.new(beers)
    render json: report.summary.merge(beerstogram: Beerstogram.new(beers))
  end

  def yearly
    beers  = fetch_beers (date - 1.year).beginning_of_day..date.end_of_day
    report = Report.new(beers)
    render json: report.summary.merge(beerstogram: Beerstogram.new(beers))
  end


  private

  def date
    params[:date] ? Date.parse(params[:date]) : Date.today
  end

  def fetch_beers(date_range)
    @data = @user.beers.where(finished_at: date_range)
  end

  def set_user
    @user = User.find_by_slug params[:user_slug]
  end
end
