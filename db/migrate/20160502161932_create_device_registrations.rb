class CreateDeviceRegistrations < ActiveRecord::Migration
  def change
    create_table :device_registrations do |t|
      t.references :user, index: true, foreign_key: true
      t.references :device, index: true, foreign_key: true

      t.timestamps null: false
    end
  end
end
