
## API Doc

User information...

/user/[:username].json
```json
{
  "username": "Klaus",
  "bierfit_since": "2016-04-27",
  "average_beer_per_session": 5,
  "average_gulp_length": 5
}
```

Beer feed...

/user/[:username]/beer.json(?limit=10)
```json
[
  {
    "finished_at": "2016-04-27 22:38:19",
    "gulps": [
      { "ml": 90, "from": "2016-04-27 16:32:12", "to": "2016-..." },
      { ... }
    ]
  },
  {
    "finished_at": ...,
    "gulps": [ ... ] },
  ...
]
```

Reports...

/user/[:username]/beer/daily.json?(:date="2016-04-27)
```json
{
  "total_beer": 12,
  "sessions": 3,
  "average_gulp_per_beer": 7,
  "average_gulp_length": 7,
  "max_gulp": 240,
  "beerstogram": {
    "00:00": 0,
    "01:00": 0,
    ...
    "16:00": 2,
    "17:00": 1,
    ...
    "22:00": 3,
    "23:00": 0,
    "24:00": 1
  }
}
```

/user/[:username]/report/weekly.json?(:date="2016-04-27)
/user/[:username]/report/monthly.json?(:date="2016-04-27)
```json
{
  "total_beer": 12,
  "sessions": 3,
  "average_gulp_per_beer": 7,
  "average_gulp_length": 7,
  "max_gulp": 240,
  "beerstogram": {
    "2016-04-20": 0,
    "2016-04-20": 7,
    "2016-04-20": 9,
    "2016-04-20": 10,
    "2016-04-20": 0
  }
}
```

/user/[:username]/report/yearly.json?(:date="2016-04-27)
```json
{
  "total_beer": 12,
  "sessions": 3,
  "average_gulp_per_beer": 7,
  "average_gulp_length": 7,
  "max_gulp": 240,
  "beerstogram": {
    "week-01": 0,
    "week-02": 7,
    "week-03": 9,
    "week-04": 10,
    "week-05": 0
  }
}
```
