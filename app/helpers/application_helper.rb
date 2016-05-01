module ApplicationHelper
  def page_title
    "Bierfit - a beer fitness tracker"
  end

  def current_user
    super || User.new
  end
end
