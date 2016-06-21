class AddUserToBeers < ActiveRecord::Migration
  def change
    add_reference :beers, :user, index: true, foreign_key: true
  end
end
