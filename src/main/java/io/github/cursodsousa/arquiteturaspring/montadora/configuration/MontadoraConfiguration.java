package io.github.cursodsousa.arquiteturaspring.montadora.configuration;

import io.github.cursodsousa.arquiteturaspring.montadora.Motor;
import io.github.cursodsousa.arquiteturaspring.montadora.TipoDeMotor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class MontadoraConfiguration {

    @Bean(name = "aspirado")
    @Primary
    public Motor motorAspirado() {
        var motor = new Motor();
        motor.setCavalos(120);
        motor.setCilindros(4);
        motor.setModelo("XPTO124");
        motor.setLitragem(2.0);
        motor.setTipo(TipoDeMotor.ASPIRADO);
        return motor;
    }

    @Bean(name = "eletrico")
    public Motor motorEletrico() {
        var motor = new Motor();
        motor.setCavalos(230);
        motor.setCilindros(3);
        motor.setModelo("TH10");
        motor.setLitragem(1.6);
        motor.setTipo(TipoDeMotor.ELETRICO);
        return motor;
    }

    @Bean(name = "turbo")
    public Motor motorTurbo() {
        var motor = new Motor();
        motor.setCavalos(300);
        motor.setCilindros(5);
        motor.setModelo("XPTO241");
        motor.setLitragem(2.0);
        motor.setTipo(TipoDeMotor.TURBO);
        return motor;
    }
}
