class AddUserToConsumeEvents < ActiveRecord::Migration
  def change
    add_column :consume_events, :user, :integer
  end
end
