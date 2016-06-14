
/**
 * mod3rate graphs - a wrapper for d3 graphs
 *
 * Just a wrapper to create some basic graphs, see https://d3js.org/ for a full
 * powered, awesome data driven documents suite.
 *
 * ----------------------------------------------------------------------------
 * "THE BEER-WARE LICENSE" (Revision 42):
 * <christoph@lipautz.org> wrote this file. As long as you retain this notice
 * you can do whatever you want with this stuff. If we meet some day, and you
 * think this stuff is worth it, you can buy me a beer in return.
 * Christoph Lipautz
 * ----------------------------------------------------------------------------
 **/

var mod3rateGraphs = {
  BaseGraph: {
    data:        [],
    graph:       null,
    target:      "body",
    initialized: false,

    fetchWidth: function() {
      return d3.select(this.target).node().getBoundingClientRect().width;
    },
    fetchHeight: function() {
      return d3.select(this.target).node().getBoundingClientRect().height;
    },

    draw: function() {
      if(this.initialized == false) {
        this.init();
      } else {
        this.update();
      }
    },

    filter: function(d) { return d; }
  },

  graphs: {},

  addGraph: function(name, obj) {
    for(var prop in this.BaseGraph) {
      if(!obj.hasOwnProperty(prop)) {
        obj[prop] = this.BaseGraph[prop];
      }
    }
    this.graphs[name] = obj;
  }
};

mod3rateGraphs.addGraph("timeline", {

  valueline: d3.svg.area(),
  xAxis:     null,
  yAxis:     null,
  x:         null,
  y:         null,

  init: function() {
    var width  = this.fetchWidth(),
        height = this.fetchHeight();
    var margin = { h: width / 25, v: height / 5 };

    // Set the ranges
    this.x = d3.time.scale().range([0, width - margin.h]);
    this.y = d3.scale.linear().range([height - 2 * margin.v, 0]);

    // Define the axes
    this.xAxis = d3.svg.axis().scale(this.x).orient("bottom").ticks(5);
    this.yAxis = d3.svg.axis().scale(this.y).orient("left").ticks(5);

    // Adds the svg canvas
    this.graph = d3.select(this.target)
      .append("svg")
        .attr("width",  width)
        .attr("height", height)
      .append("g")
        .attr("transform", "translate("+margin.h+", "+margin.v+")");

    var data = this.data.map(this.filter);

    // Define the area
    this.valueline
      .x(function(d) { return this.x(d.time); })
      .y0(height)
      .y1(function(d) { return this.y(d.value); });

    // Scale the range of the data
    this.x.domain(d3.extent(data,  function(d) { return d.time;  }));
    this.y.domain([0, d3.max(data, function(d) { return d.value; })]);

    // Add the valueline path.
    this.graph.append("path")
      .attr("class", "line")
      .attr("d", this.valueline(data));

    // Add the X Axis
    this.graph.append("g")
      .attr("class", "x axis")
      .attr("transform", "translate(0, "+(height - 2 * margin.v)+")")
      .call(this.xAxis);

    // Add the Y Axis
    this.graph.append("g")
      .attr("class", "y axis")
      .call(this.yAxis);

    this.initialized = true;
  },

  update: function() {
    var data = this.data.map(this.filter);

    // Scale the range of the data
    this.x.domain(d3.extent(data,  function(d) { return d.time;  }));
    this.y.domain([0, d3.max(data, function(d) { return d.value; })]);

    // Make the changes
    var graph = this.graph.transition().duration(750);
    graph.select(".line").attr("d", this.valueline(data));
    graph.select(".x.axis").call(this.xAxis);
    graph.select(".y.axis").call(this.yAxis);
  }

});

mod3rateGraphs.addGraph("timeline", {

  valueline: d3.svg.line(),
  xAxis:     null,
  yAxis:     null,
  x:         null,
  y:         null,

  init: function() {
    var width  = this.fetchWidth(),
        height = this.fetchHeight();
    var margin = { h: width / 25, v: height / 5 };

    // Set the ranges
    this.x = d3.time.scale().range([0, width - margin.h]);
    this.y = d3.scale.linear().range([height - 2 * margin.v, 0]);

    // Define the axes
    this.xAxis = d3.svg.axis().scale(this.x).orient("bottom").ticks(5);
    this.yAxis = d3.svg.axis().scale(this.y).orient("left").ticks(5);

    // Adds the svg canvas
    this.graph = d3.select(this.target)
      .append("svg")
        .attr("width",  width)
        .attr("height", height)
      .append("g")
        .attr("transform", "translate("+margin.h+", "+margin.v+")");

    var data = this.data.map(this.filter);

    // Define the line
    this.valueline = this.valueline
      .x(function(d) { return this.x(d.time); })
      .y(function(d) { return this.y(d.value); });

    // Scale the range of the data
    this.x.domain(d3.extent(data,  function(d) { return d.time;  }));
    this.y.domain([0, d3.max(data, function(d) { return d.value; })]);

    // Add the valueline path.
    this.graph.append("path")
      .attr("class", "line")
      .attr("d", this.valueline(data));

    // Add the X Axis
    this.graph.append("g")
      .attr("class", "x axis")
      .attr("transform", "translate(0, "+(height - 2 * margin.v)+")")
      .call(this.xAxis);

    // Add the Y Axis
    this.graph.append("g")
      .attr("class", "y axis")
      .call(this.yAxis);

    this.initialized = true;
  },

  update: function() {
    var data = this.data.map(this.filter);

    // Scale the range of the data
    this.x.domain(d3.extent(data,  function(d) { return d.time;  }));
    this.y.domain([0, d3.max(data, function(d) { return d.value; })]);

    //this.graph = this.graph.transition();

    // Make the changes
    var graph = this.graph.transition().duration(750);
    graph.select(".line").attr("d", this.valueline(data));
    graph.select(".x.axis").call(this.xAxis);
    graph.select(".y.axis").call(this.yAxis);
  }

});

var mod3rate = (function() {
  if(typeof d3 === "undefined") {
    console.error("mod3erate requires d3 as it works as a wrapper");
  }

  var graph;

  var graphFactory = function(name) {
    var name = name.toLowerCase();
    graph    = mod3rateGraphs.graphs[name];

    if(typeof graph === "undefined") {
        console.error("no graph "+name+" registered");
    }

    return this;
  };

  var setTarget = function(target) {
    graph.target = target;

    return this;
  };

  var setFilter = function(filter) {
    graph.filter = filter;

    return this;
  };

  var setData = function(data) {
    graph.data = data;

    return this;
  };

  var draw = function(data) {
    if(typeof data !== "undefined") {
      setData(data);
    }
    graph.draw();

    return this;
  };

  return {
    use:    graphFactory,
    on:     setTarget,
    filter: setFilter,
    data:   setData,
    draw:   draw
  };
})();

