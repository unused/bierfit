class AddUserToConsumeEvent < ActiveRecord::Migration
  def change
    remove_column :consume_events, :user
    add_reference :consume_events, :user, index: true, foreign_key: true
  end
end
