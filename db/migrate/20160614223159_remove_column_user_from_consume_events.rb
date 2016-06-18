class RemoveColumnUserFromConsumeEvents < ActiveRecord::Migration
  def change
    remove_column :consume_events, :user, :integer
  end
end
