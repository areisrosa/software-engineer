
About RSpec
===========
RSpec began life in 2005 as an experiment by Steven Baker, with early contributions from Dave Astels and Aslak Hellesøy. David Chelimsky joined the team that summer, and accepted leadership of the project in 2006. David also built rspec-rails, which provided tight integration with [Ruby on Rails](https://rubyonrails.org/).

RSpec 1.0 was released in May of 2007, and included many of the features that are still present in RSpec today. RSpec 1's runner had many great features but had reached a point where it was slow and hardto continue evolving it.

In late 2008, Chad Humphries built [Micronaut](https://github.com/spicycode/micronaut), a new spec runner, to address these problems. Micronaut also included a new metadata system that provided much greater flexibility than RSpec 1 had.

In early 2010, after the release of RSpec 1.3, David and [Chad began working on RSpec 2](http://blog.davidchelimsky.net/blog/2010/01/24/rspec-20-in-the-works/). The project got split into separate, modular pieces that could be used individually or all together. Micronaut was used as the basis of rspec-core, the new runner. [RSpec 2 was released](http://blog.davidchelimsky.net/blog/2010/10/10/rspec-200-is-released/) in October 2010 after nearly a year of effort.

In November 2012, after leading the project for 6 years, David decided to move on to other things. He asked Myron Marston to take over as lead RSpec maintainer and Andy Lindeman to take over as lead rspec-rails maintainer.

[Work on RSpec 3](http://rspec.info/blog/2013/07/the-plan-for-rspec-3/) began in July 2013 and it [was released in June 2014](http://rspec.info/blog/2014/06/rspec-2-99-0-and-3-0-0-have-been-released/). RSpec 3 was a bit of a "spring cleaning" for RSpec, removing much cruft (some of which dated back to RSpec 1!). It also provided [verifying doubles](https://rhnh.net/2013/12/10/new-in-rspec-3-verifying-doubles/), [composable matchers](http://rspec.info/blog/2014/01/new-in-rspec-3-composable-matchers/), a new syntax that allows RSpec to be used with no monkey patching, and [many other new features](http://rspec.info/blog/2014/05/notable-changes-in-rspec-3/). Andy Lindeman retired from the team and asked Aaron Kromer to take over as rspec-rails maintainer.

Today, RSpec continues to improve and evolve thanks to the input of a large community and the work of hundreds of contributors. More information acess: [RSpec](http://rspec.info) and See [Documentation](http://rspec.info/documentation/) for links to documentation for all gems.

## Getting Started With RSpec

RSpec 3 is a productive Ruby test framework. We say productive because everything about it—its style, API, libraries, and settings—are designed to support you as you write great software. Writing effective tests helps you toward that goal of shipping your application. We have a specific definition of effective here: does this test pay for the cost of writing and running it? A good test will provide at least one of these benefits:

  * Design guidance: helping you distill all those fantastic ideas in your head into running, maintainable code;
  * Safety net: finding errors in your code before your customers do;
  * Documentation: capturing the behavior of a working system to help its
  maintainers.

As you follow along through the examples in this book, you’ll practice several habits that will help you test effectively:

  * When you describe precisely what you want your program to do, you avoid being too strict (and failing when an irrelevant detail changes) or too lax (and getting false confidence from incomplete tests).
  * By writing your specs to report failure at the right level of detail, you give just enough information to find the cause of a problem—without drowning in excessive output.
  * By clearly separating essential test code from noisy setup code, you communicate what’s actually expected of the application—and you avoid repeating unnecessary detail.
  * When you reorder, profile, and filter your specs, you unearth order dependencies, slow tests, and incomplete work.

## RSpec on Rails

# rspec-rails [![Build Status](https://secure.travis-ci.org/rspec/rspec-rails.svg?branch=master)](http://travis-ci.org/rspec/rspec-rails) [![Code Climate](https://img.shields.io/codeclimate/github/rspec/rspec-rails.svg)](https://codeclimate.com/github/rspec/rspec-rails)
**rspec-rails** is a testing framework for Rails 3.x, 4.x and 5.0.

Use **[rspec-rails 1.x](http://github.com/dchelimsky/rspec-rails)** for Rails
2.x.

## Installation RSpec

First, to use RSpec 3, you need a recent version of Ruby. We’ve tested our examples in this book with Ruby 2.4, and encourage you to use that version for the easiest path. You may get slightly different results on other versions of Ruby. If you’re using something older, go to the Ruby download page and grab a newer one.

RSpec is made of three independent Ruby gems:

  * rspec-core is the overall test harness that runs your specs.
  * rspec-expectations provides a readable, powerful syntax for checking properties of your code.
  * rspec-mocks makes it easy to isolate the code you’re testing from the rest of the system.

Add `rspec-rails` to **both** the `:development` and `:test` groups in the
`Gemfile`:

```ruby
group :development, :test do
  gem 'rspec-rails', '~> 3.6'
end
```
Want to run against the `master` branch? You'll need to include the dependent
RSpec repos as well. Add the following to your `Gemfile`:

```ruby
%w[rspec-core rspec-expectations rspec-mocks rspec-rails rspec-support].each do |lib|
  gem lib, :git => "https://github.com/rspec/#{lib}.git", :branch => 'master'
end
```

Download and install by running:

```sh
$ bundle install
```

Initialize the `spec/` directory (where specs will reside) with:

```sh
$ rails generate rspec:install
```

This adds the following files which are used for configuration:

- `.rspec`, **which contains default command-line flags**
- `spec/spec_helper.rb`, **which contains configuration options** 
- `spec/rails_helper.rb`

Check the comments in each file for more information.

Use the `rspec` command to run your specs:

```sh
$ bundle exec rspec
```

By default the above will run all `_spec.rb` files in the `spec` directory. For
more details about this see the [RSpec spec file
docs](https://www.relishapp.com/rspec/rspec-core/docs/spec-files).

To run only a subset of these specs use the following command:

```sh
# Run only model specs
$ bundle exec rspec spec/models

# Run only specs for AccountsController
$ bundle exec rspec spec/controllers/accounts_controller_spec.rb

# Run only spec on line 8 of AccountsController
$ bundle exec rspec spec/controllers/accounts_controller_spec.rb:8
```

Specs can also be run via `rake spec`, though this command may be slower to
start than the `rspec` command.

In Rails 4, you may want to create a binstub for the `rspec` command so it can
be run via `bin/rspec`:

```sh
$ bundle binstubs rspec-core
```

### Upgrade Note

For detailed information on the general RSpec 3.x upgrade process see the
[RSpec Upgrade docs](https://relishapp.com/rspec/docs/upgrade).

There are three particular `rspec-rails` specific changes to be aware of:

1. [The default helper files created in RSpec 3.x have changed](https://www.relishapp.com/rspec/rspec-rails/docs/upgrade#default-helper-files)
2. [File-type inference disabled by default](https://www.relishapp.com/rspec/rspec-rails/docs/upgrade#file-type-inference-disabled)
3. [Rails 4.x `ActiveRecord::Migration` pending migration checks](https://www.relishapp.com/rspec/rspec-rails/docs/upgrade#pending-migration-checks)
4. Extraction of `stub_model` and `mock_model` to
   [`rspec-activemodel-mocks`](https://github.com/rspec/rspec-activemodel-mocks)
5. In Rails 5.x, controller testing has been moved to its own gem which is [rails-controller-testing](https://github.com/rails/rails-controller-testing). Using `assigns` in your controller specs without adding this gem will no longer work.
6. `rspec-rails` now includes two helpers, `spec_helper.rb` and `rails_helper.rb`.
   `spec_helper.rb` is the conventional RSpec configuration helper, whilst the
    Rails specific loading and bootstrapping has moved to the `rails_helper.rb`
    file. Rails specs now need this file required beforehand either at the top
    of the specific file (recommended) or a common configuration location such
    as your `.rspec` file.

Please see the [RSpec Rails Upgrade
docs](https://www.relishapp.com/rspec/rspec-rails/docs/upgrade) for full
details.

**NOTE:** Generators run in RSpec 3.x will now require `rails_helper` instead
of `spec_helper`.

### Generators

Once installed, RSpec will generate spec files instead of Test::Unit test files
when commands like `rails generate model` and `rails generate controller` are
used.

You may also invoke RSpec generators independently. For instance,
running `rails generate rspec:model` will generate a model spec. For more
information, see [list of all
generators](https://www.relishapp.com/rspec/rspec-rails/docs/generators).

## Contributing

Once you've set up the environment, you'll need to cd into the working
directory of whichever repo you want to work in. From there you can run the
specs and cucumber features, and make patches.

NOTE: You do not need to use rspec-dev to work on a specific RSpec repo. You
can treat each RSpec repo as an independent project.
Please see the following files:

For `rspec-rails`-specific development information, see

- [Build details](https://github.com/rspec/rspec-rails/blob/master/BUILD_DETAIL.md)
- [Code of Conduct](https://github.com/rspec/rspec-rails/blob/master/CODE_OF_CONDUCT.md)
- [Detailed contributing guide](https://github.com/rspec/rspec-rails/blob/master/CONTRIBUTING.md)
- [Development setup guide](https://github.com/rspec/rspec-rails/blob/master/DEVELOPMENT.md)


## Model Specs

Use model specs to describe behavior of models (usually ActiveRecord-based) in
the application.

Model specs default to residing in the `spec/models` folder. Tagging any
context with the metadata `:type => :model` treats its examples as model
specs.

For example:

```ruby
require "rails_helper"

RSpec.describe Post, :type => :model do
  context "with 2 or more comments" do
    it "orders them in reverse chronologically" do
      post = Post.create!
      comment1 = post.comments.create!(:body => "first comment")
      comment2 = post.comments.create!(:body => "second comment")
      expect(post.reload.comments).to eq([comment2, comment1])
    end
  end
end
```

For more information, see [cucumber scenarios for model
specs](https://www.relishapp.com/rspec/rspec-rails/docs/model-specs).

## Request Specs

Use request specs to describe the client-facing behavior of the application —
specifically, the HTTP response to be issued for a given request (a.k.a.
integration tests). Since such client-facing behavior encompasses controller
actions, this is the type of spec to use for controller testing.

Request specs default to residing in the `spec/requests`, `spec/api`, and
`spec/integration` directories. Tagging any context with the metadata `:type =>
:request` treats its examples as request specs.

Request specs mix in behavior from
[ActionDispatch::Integration::Runner](http://api.rubyonrails.org/classes/ActionDispatch/Integration/Runner.html),
which is the basis for [Rails' integration
tests](http://guides.rubyonrails.org/testing.html#integration-testing).

```ruby
require 'rails_helper'

RSpec.describe "home page", :type => :request do
  it "displays the user's username after successful login" do
    user = User.create!(:username => "jdoe", :password => "secret")
    get "/login"
    assert_select "form.login" do
      assert_select "input[name=?]", "username"
      assert_select "input[name=?]", "password"
      assert_select "input[type=?]", "submit"
    end

    post "/login", :username => "jdoe", :password => "secret"
    assert_select ".header .username", :text => "jdoe"
  end
end
```

The above example uses only standard Rails and RSpec APIs, but many
RSpec/Rails users like to use extension libraries like
[FactoryBot](https://github.com/thoughtbot/factory_bot) and
[Capybara](https://github.com/jnicklas/capybara):

```ruby
require 'rails_helper'

RSpec.describe "home page", :type => :request do
  it "displays the user's username after successful login" do
    user = FactoryBot.create(:user, :username => "jdoe", :password => "secret")
    visit "/login"
    fill_in "Username", :with => "jdoe"
    fill_in "Password", :with => "secret"
    click_button "Log in"

    expect(page).to have_selector(".header .username", :text => "jdoe")
  end
end
```

FactoryBot decouples this example from changes to validation requirements,
which can be encoded into the underlying factory definition without requiring
changes to this example.

Among other benefits, Capybara binds the form post to the generated HTML, which
means we don't need to specify them separately. Note that Capybara's DSL as
shown is, by default, only available in specs in the spec/features directory.
For more information, see the [Capybara integration
docs](http://rubydoc.info/gems/rspec-rails/file/Capybara.md).

There are several other Ruby libs that implement the factory pattern or provide
a DSL for request specs (a.k.a. acceptance or integration specs), but
FactoryBot and Capybara seem to be the most widely used. Whether you choose
these or other libs, we strongly recommend using something for each of these
roles.

For more information, see [cucumber scenarios for request
specs](https://relishapp.com/rspec/rspec-rails/docs/request-specs/request-spec).

## Controller Specs

Controller specs can be used to describe the behavior of Rails controllers. As
of version 3.5, however, controller specs are discouraged in favor of request
specs (which also focus largely on controllers, but capture other critical
aspects of application behavior as well). Controller specs will continue to be
supported until at least version 4.0 (see the [release
notes](http://rspec.info/blog/2016/07/rspec-3-5-has-been-released/#rails-support-for-rails-5)
for details).

For more information, see [cucumber scenarios for controller
specs](https://www.relishapp.com/rspec/rspec-rails/docs/controller-specs).

## Feature Specs

Feature specs test your application from the outside by simulating a browser.
[`capybara`](https://github.com/jnicklas/capybara) is used to manage the
simulated browser.

Feature specs default to residing in the `spec/features` folder. Tagging any
context with the metadata `:type => :feature` treats its examples as feature
specs.

Feature specs mix in functionality from the capybara gem, thus they require
`capybara` to use. To use feature specs, add `capybara` to the `Gemfile`:

```ruby
gem "capybara"
```

For more information, see the [cucumber scenarios for feature
specs](https://www.relishapp.com/rspec/rspec-rails/v/3-4/docs/feature-specs/feature-spec).

## Mailer specs

By default Mailer specs reside in the `spec/mailers` folder. Adding the metadata
`:type => :mailer` to any context makes its examples be treated as mailer specs.

`ActionMailer::TestCase::Behavior` is mixed into your mailer specs.

```ruby
require "rails_helper"

RSpec.describe Notifications, :type => :mailer do
  describe "notify" do
    let(:mail) { Notifications.signup }

    it "renders the headers" do
      expect(mail.subject).to eq("Signup")
      expect(mail.to).to eq(["to@example.org"])
      expect(mail.from).to eq(["from@example.com"])
    end

    it "renders the body" do
      expect(mail.body.encoded).to match("Hi")
    end
  end
end
```

For more information, see the [cucumber scenarios for mailer specs
](https://relishapp.com/rspec/rspec-rails/v/3-4/docs/mailer-specs).

## Job specs

Tagging a context with the metadata `:type => :job` treats its examples as job
specs. Typically these specs will live in `spec/jobs`.

```ruby
require 'rails_helper'

RSpec.describe UploadBackupsJob, :type => :job do
  describe "#perform_later" do
    it "uploads a backup" do
      ActiveJob::Base.queue_adapter = :test
      UploadBackupsJob.perform_later('backup')
      expect(UploadBackupsJob).to have_been_enqueued
    end
  end
end
```

For more information, see the [cucumber scenarios for job specs
](https://relishapp.com/rspec/rspec-rails/docs/job-specs).

## View specs

View specs default to residing in the `spec/views` folder. Tagging any context
with the metadata `:type => :view` treats its examples as view specs.

View specs mix in `ActionView::TestCase::Behavior`.

```ruby
require 'rails_helper'

RSpec.describe "events/index", :type => :view do
  it "renders _event partial for each event" do
    assign(:events, [double(Event), double(Event)])
    render
    expect(view).to render_template(:partial => "_event", :count => 2)
  end
end

RSpec.describe "events/show", :type => :view do
  it "displays the event location" do
    assign(:event, Event.new(:location => "Chicago"))
    render
    expect(rendered).to include("Chicago")
  end
end
```

View specs infer the controller name and path from the path to the view
template. e.g. if the template is `events/index.html.erb` then:

```ruby
controller.controller_path == "events"
controller.request.path_parameters[:controller] == "events"
```

This means that most of the time you don't need to set these values. When
spec'ing a partial that is included across different controllers, you _may_
need to override these values before rendering the view.

To provide a layout for the render, you'll need to specify _both_ the template
and the layout explicitly. For example:

```ruby
render :template => "events/show", :layout => "layouts/application"
```

### `assign(key, val)`

Use this to assign values to instance variables in the view:

```ruby
assign(:widget, Widget.new)
render
```

The code above assigns `Widget.new` to the `@widget` variable in the view, and
then renders the view.

Note that because view specs mix in `ActionView::TestCase` behavior, any
instance variables you set will be transparently propagated into your views
(similar to how instance variables you set in controller actions are made
available in views). For example:

```ruby
@widget = Widget.new
render # @widget is available inside the view
```

RSpec doesn't officially support this pattern, which only works as a
side-effect of the inclusion of `ActionView::TestCase`. Be aware that it may be
made unavailable in the future.

#### Upgrade note

```ruby
# rspec-rails-1.x
assigns[key] = value

# rspec-rails-2.x+
assign(key, value)
```

### `rendered`

This represents the rendered view.

```ruby
render
expect(rendered).to match /Some text expected to appear on the page/
```

#### Upgrade note

```ruby
# rspec-rails-1.x
render
response.should xxx

# rspec-rails-2.x+
render
rendered.should xxx

# rspec-rails-2.x+ with expect syntax
render
expect(rendered).to xxx
```

## Routing specs

Routing specs default to residing in the `spec/routing` folder. Tagging any
context with the metadata `:type => :routing` treats its examples as routing
specs.

```ruby
require 'rails_helper'

RSpec.describe "routing to profiles", :type => :routing do
  it "routes /profile/:username to profile#show for username" do
    expect(:get => "/profiles/jsmith").to route_to(
      :controller => "profiles",
      :action => "show",
      :username => "jsmith"
    )
  end

  it "does not expose a list of profiles" do
    expect(:get => "/profiles").not_to be_routable
  end
end
```

### Upgrade note

`route_for` from rspec-rails-1.x is gone. Use `route_to` and `be_routable`
instead.

## Helper specs

Helper specs default to residing in the `spec/helpers` folder. Tagging any
context with the metadata `:type => :helper` treats its examples as helper
specs.

Helper specs mix in ActionView::TestCase::Behavior. A `helper` object is
provided which mixes in the helper module being spec'd, along with
`ApplicationHelper` (if present).

```ruby
require 'rails_helper'

RSpec.describe EventsHelper, :type => :helper do
  describe "#link_to_event" do
    it "displays the title, and formatted date" do
      event = Event.new("Ruby Kaigi", Date.new(2010, 8, 27))
      # helper is an instance of ActionView::Base configured with the
      # EventsHelper and all of Rails' built-in helpers
      expect(helper.link_to_event).to match /Ruby Kaigi, 27 Aug, 2010/
    end
  end
end
```

## Matchers

Several domain-specific matchers are provided to each of the example group
types. Most simply delegate to their equivalent Rails' assertions.

### `be_a_new`

- Available in all specs
- Primarily intended for controller specs

```ruby
expect(object).to be_a_new(Widget)
```

Passes if the object is a `Widget` and returns true for `new_record?`

### `render_template`

- Delegates to Rails' `assert_template`
- Available in request, controller, and view specs

In request and controller specs, apply to the `response` object:

```ruby
expect(response).to render_template("new")
```

In view specs, apply to the `view` object:

```ruby
expect(view).to render_template(:partial => "_form", :locals => { :widget => widget } )
```

### `redirect_to`

- Delegates to `assert_redirect`
- Available in request and controller specs

```ruby
expect(response).to redirect_to(widgets_path)
```

### `route_to`

- Delegates to Rails' `assert_routing`
- Available in routing and controller specs

```ruby
expect(:get => "/widgets").to route_to(:controller => "widgets", :action => "index")
```

### `be_routable`

Passes if the path is recognized by Rails' routing. This is primarily intended
to be used with `not_to` to specify standard CRUD routes which should not be
routable.

```ruby
expect(:get => "/widgets/1/edit").not_to be_routable
```

### `have_http_status`

- Passes if `response` has a matching HTTP status code
- The following symbolic status codes are allowed:
  - `Rack::Utils::SYMBOL_TO_STATUS_CODE`
  - One of the defined `ActionDispatch::TestResponse` aliases:
    - `:error`
    - `:missing`
    - `:redirect`
    - `:success`
- Available in controller, feature, and request specs.

In controller and request specs, apply to the `response` object:

```ruby
expect(response).to have_http_status(201)
expect(response).not_to have_http_status(:created)
```

In feature specs, apply to the `page` object:

```ruby
expect(page).to have_http_status(:success)
```

## `rake` tasks

Several rake tasks are provided as a convenience for working with RSpec. To run
the entire spec suite use `rake spec`. To run a subset of specs use the
associated type task, for example `rake spec:models`.

A full list of the available rake tasks can be seen by running `rake -T | grep
spec`.

### Customizing `rake` tasks

If you want to customize the behavior of `rake spec`, you may [define your own
task in the `Rakefile` for your
project](https://www.relishapp.com/rspec/rspec-core/docs/command-line/rake-task).
However, you must first clear the task that rspec-rails defined:

```ruby
task("spec").clear
```


## Also see

* [https://github.com/rspec/rspec](https://github.com/rspec/rspec)
* [https://github.com/rspec/rspec-core](https://github.com/rspec/rspec-core)
* [https://github.com/rspec/rspec-expectations](https://github.com/rspec/rspec-expectations)
* [https://github.com/rspec/rspec-mocks](https://github.com/rspec/rspec-mocks)

## Feature Requests & Bugs

See <http://github.com/rspec/rspec-rails/issues>
