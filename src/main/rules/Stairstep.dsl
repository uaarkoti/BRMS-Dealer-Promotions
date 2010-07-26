[condition][]When attainment percentage is greater than {lowPercentage} and less than {highPercentage}=$dealer : Dealer(attainment >= ({lowPercentage} * objective) && attainment < ({highPercentage} * objective))
[condition][]When attainment units is greater than {low} and less than {high}=$dealer : Dealer(attainment >= {low} && <= {high})
[condition][]When attainment percentage is greater than {percentage}=$dealer : Dealer(attainment >= ({percentage} * objective))
[condition][]When attainment units is greater than {units}=$dealer : Dealer(attainment >= {units})
[condition][]Get Lancer count=$lancers: Double() from accumulate (v : Vehicle (model == 'Lancer'),count (v))
[condition][]Get Raiders count=$raiders: Double() from accumulate (v : Vehicle (model == 'Raiders'),count (v))
[condition][]Get Endeavor count=$endeavors: Double() from accumulate (v : Vehicle (model == 'Endeavor'),count (v))
[condition][]Get All Model count=$vehicles: Double() from accumulate (v : Vehicle (),count (v))
[consequence][]Add award of ${lancerAward} per Lancer and ${nonLancerAward} per other eligible vehicles=$dealer.checkAndSetTotalAward({lancerAward} * $lancers + {nonLancerAward} * ($vehicles - $lancers - $endeavors - $raiders));
