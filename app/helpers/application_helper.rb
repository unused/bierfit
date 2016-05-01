module ApplicationHelper
  def page_title
    "foobar title"
  end

  def current_user
    super || User.new
  end
end
