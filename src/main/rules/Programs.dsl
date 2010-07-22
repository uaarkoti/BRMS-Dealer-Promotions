[consequence][]Log : "{message}"=System.out.println("{message}");
[consequence][]Log ruleName=System.out.println(drools.rule.name);
[consequence][]Retract dealer=retract($dealer);
[condition][]Calculate number of Lancers=$lancers: Double() from accumulate (v : Vehicle (model == 'Lancer'),count (v))
[condition][]Calculate number of Vehicles=$vehicles : Double() from accumulate (v : Vehicle (),count (v))
[consequence][]Add reward amount of {amount} per Lancer=$dealer.setTotalAward( $dealer.getTotalAward() + {amount} * $lancers);
[consequence][]Add reward amount of {amount} per Non Lancer=$dealer.setTotalAward( $dealer.getTotalAward() + {amount} * ($vehicles - $lancers));
[condition][]Dealer attainment percentage greater than {lowPercentage} and less than {highPercentage} and attainment quantity greater than {lowVehicles} and less than {highVehicles}=$dealer : Dealer((attainment >= ({lowPercentage} * objective) && attainment < ({highPercentage} * objective)) && (attainment >= {lowVehicles} && <= {highVehicles}))
[condition][]Dealer attainment percentage greater than {lowPercentage} or attainment quantity greater than {lowVehicles}=$dealer : Dealer((attainment >= ({lowPercentage} * objective) || attainment >= {lowVehicles}))
[condition][]Dealer attainment percentage greater than {lowPercentage} and less than {highPercentage} or attainment quantity greater than {lowVehicles}=$dealer : Dealer((attainment >= ({lowPercentage} * objective) && attainment < ({highPercentage} * objective)) || (attainment >= {lowVehicles}))
